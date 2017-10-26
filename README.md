# SpringDataJPA-Tips

## JPA Query new XXXX(args..)를 사용하여 조회. 

@Query Annotation 등으로 특정 컬럼만 호출하도록 한다.
findById와 같이 일반적인 select에서는 해당 entity의 모든속성을 호출하게 되어있다. 이경우 불필요한 컬럼과 자식entity까지 가져오게 되므로 아래와 같이 처리하는게 좋을 수도 있다.

예) company table 에서 code 컬럼만 조회.
```java
@Query("select new Company(o.code) from Company o where o.id = :id")
Company findColumnById(@Param("id")Long id);
```


## JPA Lock - @Version 사용하기 
기본적으로 @Version사용시 낙관적 락이 적용된다.(LockModeType.NONE) 

A 사용자가 [OrderId 1번 조회후 ProductId를 10으로 변경] 
B 사용자가 [OrderId 1번 조회후 ProductId를 5으로 변경] 

먼저 A사용자가 ProductId의 변경을 시동하지만 이런저런 이슈로 하나의 TX가 15초 걸린다고 가정하고,
(http://localhost:8080/orders/1/products/10/update-tx-lock?ms=15000)

이후 B사용자는 걸림없이 ProductId를 5로 수정했다.
(http://localhost:8080/orders/1/products/10/update-tx-lock?ms=0)

이경우 A사용자는 먼저 find가 실행되어 해당 Version을 가지게 되고, B사용자는 늦게 find가 실행되어 A사용자보다 높은 Version을 갖게된다.

A사용자의 경우 OptimisticLock과련 오류가 throw되게 되고, B사용자의 ProductId로 업데이트된다.

중간에 find만 할경우는 Update가 완료된 B사용자의  ProductId가 적용되어 보이게된다.
(http://localhost:8080/orders/1?ms=0)


## JPA Spring Data Redis와 같이 사용하기
https://redis.io/download -> Redis 설치 
```java
application.properties 에 redis정보를 추가한다.
spring.redis.host=127.0.0.1
spring.redis.port=6379
```

설정 
```java
@Configuration
@EnableCaching
public class RedisCacheConfiguration {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;

	...
}
```

## JPA Hibernate Second Level Cache  를 적용

```java
@..
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Company extends AuditingEntity implements Serializable {

	public Company(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
```

## Spring Boot 1.5.8 Up!