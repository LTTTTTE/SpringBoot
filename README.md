# Springboot

### Ioc 제어의역전 inversion of control
- 객체의 의존성을 spring framework가 넣고뺌(관리함)


### 의존성?
- 사람 객체안에 장기 객체를 사용하면
- 사람은 장기에 의존함 (장기없이 사람클래스가 안돌아감)
- 사람 클래스안에서 new 장기 를 통해 장기객체를 사용할경우
- 사람이 스스로 자신의 의존성 (장기) 를 관리함

### DI 의존성주입 dependency injection
- 사람으로 예를 들면 
- 사람 클래스내부에서 new 장기를 통해 장기를 생성하지않고
- 외부(springframework) 로 부터 관리되는 장기를 받아 
- 사람객체가 돌아감


### Ioc Container 

- Ioc를 구현하기 위하여 객체를 관리
- spring에서의 Container
- Beanfactory              <-(implement)ApplicationContext


### Bean
- spring이 관리하는 객체


### Ioc / DI 짓거리를 하는이유

- 객체지향에서의 OCP (개방-폐쇄원칙)를 지키기 위해서 : 코드의 확장성과 재사용성 때문이다.


### AOP Aspect Oriented Programming

- 각 객체들이 사용하는 핵심기술들을 모듈화하여
- 한곳에서 관리하는 프로그래밍 기법이다.
- (같은 서비스코드들 때어내서 한 소스로 모듈화하여 코드 재사용성)

### PSA

- ?
