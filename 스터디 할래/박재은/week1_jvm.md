# JVM이란 무엇이며 자바 코드는 어떻게 실행하는 것인가


`학습할 것`
- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

---------------------------------------------

# JVM이란 무엇인가

JVM이란 JAVA Virtual Machine(자바 가상 머신)의 약칭으로 JAVA의 바이트코드를 OS에 맞게 해석 해주는 역할을 한다.

## - JVM이 나오게 된 배경

C/C++는 컴파일 플랫폼과 타켓 플랫폼이 다를 경우 프로그램이 동작하지 않는다.
(환경, 플랫폼 = 운영체제 + CPU 아키텍처)

즉 동일한 플랫폼에서 컴파일과 실행을 같이 한다면 프로그램은 아무 문제 없이 동작하지만 플랫폼이 달라질 경우 타겟 플랫폼에서 프로그램이 동작하지 않는다.

-> 이로 인해 크로스 컴파일을 통해 각각의 실행하고자 하는 운영체제에 맞는 프로그램을 만들어야 했다. (크로스 컴파일 : 타겟 플랫폼에 맞춰 컴파일 하는 것)

<br/>

![java compile](https://docs.oracle.com/javase/tutorial/figures/getStarted/getStarted-compiler.gif)

출처 : https://docs.oracle.com/javase/tutorial/figures/getStarted/getStarted-compiler.gif


이러한 불편함을 해소하기 위해 **자바 컴파일러**를 통해 **자바 소스코드(java 파일)를 바이트 코드(class 파일)로** 변환하고 바이트코드는 기계어가 아니기 때문에 os에서 실행시키기 위해 **바이트 코드를 기계어로** 번역해주는 과정을 한 번 더 거치는 **JVM**이 나오게 되었다.

즉 자바 바이트 코드는 타겟 플랫폼에 상관없이 JVM 위에서 동작하고 JVM은 타겟 플랫폼에 의존한다.

---------------------------------------------
# 컴파일 하는 방법


#### cmd에서 자바 컴파일

Java Complier에 의해 .java 파일을 .class 파일 즉 자바 바이트 코드로 만들어보자.

Java Complier는 JDK를 설치하면 bin 디렉터리의 javac.exe로 존재한다. javac 명령어를 통해 .class 파일을 생성할 수 있다.

```
public class test {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
"Hello World"를 출력하는 .java 파일을 생성하고 파일이 있는 디렉터리에서 **javac { java 파일 명 }** 을 통해 컴파일한다.
```
C:\Users\user>javac test.java
```
현재 위치에 .class 파일이 생성되는 것을 확인할 수 있다.

#### 자바 컴파일 과정
보통 IDE나 terminal 환경에서 .java파일을 생성하게 되는데 이 때 build를 통해 .class 파일을 생성하게 된다.
이는 아직 컴퓨터가 읽을 수 없는 자바 바이트코드이다.

---------------------------------
# 실행하는 방법

위에서 만든 class 파일을 이용하여 java 명령어를 통해 실행시킬 수 있다.

java 명령어로 JDK의 bin 디렉터리에 java.exe를 실행시켜 JVM을 구동할 수 있다.

```
C:\Users\user>java test
Hello World
```
"Hello World"가 출력되면서 test.class 파일이 실행된걸 확인할 수 있다.

---------------------------------
# 바이트코드란 무엇인가

바이트코드는 특정 하드웨어가 아닌 가상 컴퓨터(VM)에서 돌아가는 실행 프로그램을 위한 이진 표현법이다. 

JVM이 이해할 수 있는 언어로 변환된 자바 소스코드를 의미한다.
자바 컴파일러에 의해 변환되는 코드의 명령어 크기가 1byte라서 자바 바이트코드라고 불린다.

바이트코드는 다시 실시간 번역기 혹은 JIT 컴파일러에 의해 바이너리 코드(컴퓨터가 인식할 수 있는 0과 1로 구성된 이진코드)로 변환된다.


---------------------------------
# JIT 컴파일러란 무엇이며 어떻게 동작하는지

<img src="https://miro.medium.com/max/1400/1*VFo0CC-chzvqJk6sls6ukQ.png" width="700px"/>

출처 : https://miro.medium.com/max/1400/1*VFo0CC-chzvqJk6sls6ukQ.png

JIT 컴파일 (Just In Time Compliation) 혹은 동적 번역(Dynamic Translation)이라고한다.

JIT 컴파일러는 프로그램을 실제 실행하는 시점에 바이트코드를 컴퓨터 프로세서(CPU)로 직접 보낼 수 있는  기계어로 번역하는 컴파일러이다.

전통적인 입장에서 컴퓨터 프로그램을 만드는 방법은 두가지로 인터프리터 방식과 정적 컴파일 방식으로 나뉜다.

- 인터프리터 방식 : 실행 중 프로그램 언어를 읽어가며 해당 기능에 대응하는 기계어 코드 실행. 자바 바이트코드를 한줄씩 실행하여 여러번 실행하는 환경에서는 다소 느리다.
- 정적 컴파일러 : 실행하기 전 프로그램 코드를 기계어로 번역

JIT 컴파일러는 인터프리터 방식의 단점을 보완하기 위해 도입되었다. 두가지의 방식을 혼합한 방식으로 생각할 수 있는데 
**인터프리터 방식으로 기계어 코드를 생성하면서 실행하다가 그 코드를 캐싱하여, 같은 함수가 여러번 불릴 때 매번 기계어 코드를 생성하는 것을 방지**한다. 

즉 같은 코드를 매번 해석하지 않고 실행할 때 컴파일하며 해당 코드를 캐싱한다. 이후에는 바뀐 부분만 컴파일하고 나머지는 캐싱된 코드를 사용하여 인터프리터의 속도를 개선할 수 있다.

---------------------------------
# JVM 구성 요소

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcQRqku%2Fbtru0vJ6Ixx%2F9qCTW7ChXc80fGfQUrT4B0%2Fimg.png" width="500px"/>

출처 : https://namu.wiki/w/%EC%9E%90%EB%B0%94%20%EA%B0%80%EC%83%81%20%EB%A8%B8%EC%8B%A0

JVM의 구성요소는 크게 3가지로 나눌 수 있다.

| 구성 요소 |	설명 |
|-------|-------------|
| Class Loader | 클래스를 Runtime Data Area에 적재한다. |
| Runtime Data Area | 런타임에 필요한 메모리 영역 |
| Execution Engine |	메서드를 실행하는 실행 엔진 |

<br/>

## Class Loader
- 런타임 시점에 클래스를 로딩한다. 인스턴스가 생성이 되면 Class Loader를 통해 메모리에 적재된다.
- 세부적으로는 크게 `Loading` (클래스 파일 탑재), `Linking` (클래스 파일을 사용하기 위해 검증하고, 기본 값으로 초기화), 그리고 `Initialization` (static field 의 값들을 정의한 값으로 초기화) 과정을 거쳐 클래스 파일을 로딩한다.

#### Loading (클래스 파일 탑재)

- 각각의 클래스 파일들이 기본으로 제공받는 클래스 파일인지 혹은 개발자가 정의한 클래스 파일인지와 같은 기준에 의해서 ClassLoader 의 수준도 세 가지로 나뉜다.

  <img src= "https://tecoble.techcourse.co.kr/static/8620cd5d0bd1f37f2e603a5a5d763b39/2f3a8/2021-07-26-classloader-process.png" width= 400px>
    
- **bootstrap class loader** : 가장 먼저 실행되는 클래스 로더이다. 자바 실행에 기본적으로 필요한 클래스 즉 rt.jar 를 포함하여, JVM 을 구동시키기 위한 가장 필수적인 라이브러리의 클래스들을 로딩한다.
- **extension class loader** : localedata, zipfs 등 다른 표준 핵심 Java Class 의 라이브러리 들을 로딩한다.(클래스들은 폴더 $JAVAHOME/jre/lib/ext_ 위치해 있다.)
- **application class loader** : Classpath 에 있는 클래스를 로딩한다. classpath나 jar파일 내에 환경변수로 지정된 폴더 내 클래스를 로딩한다. (여기에 개발자들이 자바 코드로 짠 클래스 파일이 포함된다.)

> 위의 각각의 ClassLoader 들을 모두 거쳤는데도, 클래스 파일을 찾지 못하게 되면, ClassNotFoundException 이라는 예외를 던진다.

<!-- 이렇게 Loading 과정에서 하위 ClassLoader 가 로딩한 클래스 파일은 상위 ClassLoader 가 로딩한 클래스 파일을 볼 수가 있습니다. 하지만 반대는 불가능합니다. 이를 Visibility 라고 하며, 각각의 클래스 파일을 계층으로 관리해줄 수 있게 합니다. 또한, 한번 JVM 에 탑재된 클래스 파일은 종료될 때까지 JVM 에서 제거되지 않습니다.-->

#### Linking (클래스 파일을 사용하기 위해 검증하고, 기본 값으로 초기화)

- verification, preparation, resolution 단계로 이루어져있다.

- **verification** : 읽어들인 바이트코드가 적절한지 확인한다. 실패시 java.lang.verifyError를 리턴
- **preparation** : static 변수들에 메모리가 할당되고 타입에 따라 기본값을 할당한다.
- **resolution** : 클래스의 `constant pool` 내의 **모든 symbolic reference**를 JVM 의 메모리 구성 요소인 **Method Area** 의 `runtime constant pool`을 통하여 **Direct Reference 라는 메모리 주소 값**으로 바꾼다. (해당 단계의 영향을 받는 JVM Instruction 요소는 new 및 instanceof 가 있다.)

#### Initialization (static field 의 값들을 정의한 값으로 초기화)
- Java 코드에서의 class 와 interface 의 static 변수 값들을 지정한 값들로 초기화 및 static block이 실행된다.


## Runtime Data Area
- JVM이 바이트코드를 실행하기 위해 사용하는 (OS로부터 별도로 할당 받은) 메모리 공간이다.
- JVM 의 Runtime Data Areas 에는 크게 Method Area, Heap, Java Stacks, PC registers 그리고 Native Method Stacks로 나뉜다.

  <img src= "https://tecoble.techcourse.co.kr/static/a0b18cc999920474a1852901e1e46ebf/6f641/2021-08-09-jvm-runtime-data-area-structure.png" width= 400px>

### 모든 스레드가 공유

#### Method Area
- 클래스로더가 클래스 파일을 읽어왔을 때 클래스와 관련된 메타데이터를 저장하고 클래스 구조, 필드, 메서드와 같은 데이터를 저장한다.
- Runtime Constant Pool 과 static 변수, 그리고 메소드 데이터와 같은 Class 데이터가 관리되는  곳이다.

#### Heap
- 런타임시, 동적으로 할당하여 사용하는 영역이다. 프로그램을 실행하면서 생성한 모든 객체 인스턴스를 저장한다.
- 여기서 문자열에 대한 정보를 가진 `String Constant Pool`과 실제 데이터를 가진 인스턴스, 배열 등이 저장된다.

### 각각의 스레드에 존재

#### Stack
- 자바 스택은 스레드 별로 존재하고 각 Thread 들은 메서드를 호출할 때마다 `Frame` 이라는 단위가 생성된다.
- 메서드 실행이 끝나면 스택 프레임은 pop되어 스택에서 제거된다.
- Frame 은 메서드에 대한 정보를 가지고 있는 Local Variable, Operand Stack 그리고 Constant Pool Reference 로 구성이 되어 있다.
  - Local Variable : 메서드 안의 지역 변수를 가지고 있다.
  - Operand Stack : 메서드 내 연산을 위해서 바이트 코드 명령문을 가지고 있다.
  - Constant Pool Reference : Constant Pool 참조를 위한 공간이다.

#### Program Counter Register

- 현재 실행 중인 JVM 주소 정보를 저장한다.
- 수행해야 하는 CPU 명령어 위치 정보를 저장한다.

#### Native Method Stack
- 자바의 바이트코드가 아닌 다른 언어로 작성된 메서드를 성능 향상을 목적으로 컴파일해서 사용하는 경우 사용된다.


## Execution Engine
- 로드된 class의 바이트코드를 실행하는 runtime module이다. class loader를 통해 jvm 내의 Runtime Data Area에 배치된 바이트코드는 Excution Engine에 의해 실행된다.

## Garbage Collector
- Heap 메모리 영역에 생성된 객체들 중 참조되지 않은 객체들을 제거 한다. System.gc()를 호출하여 실행할 수 있다. GC 동작시간은 정해져있지 않으므로 언제 제거하는지는 알 수 없다. GC를 수행하는 동안 GC Thread를 제외한 다른 모든 Thread는 일시 정지한다.
## Interpreter
## JIT compiler

---------------------------------
# JDK와 JRE의 차이

- JDK(Java Development Kit)
자바 애플리케이션의 개발 환경이다. 자바를 사용하귀 위해 필요한 기능을 갖춘 자바용 SDK이다. JDK를 이용해 **프로그램을 생성, 실행, 컴파일** 할 수 있다.
- JRE(Java Runtime Environment)
JVM + 자바 클래스 라이브러리(Java Class Library) 등으로 구성되어 있다.

즉 JDK는 자바 프로그램을 실행, 컴파일, 개발용 도구이며 JRE, JVM를 모두 포함하는 포괄적이 키트이다.
JRE는 자바 프로그램을 실행할 수 있게 하는 도구이다. JVM을 포함하고 있다.

자바9부터 JRE가 사라지는 이유는 사실 JDK가 JRE에 다 들어있기 때문이다.
