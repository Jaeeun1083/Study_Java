# 연산자

`학습할 것 (필수)`

- 선택문
- 반복문

`과제`

- JUnit 5 학습하세요.
- live-study 대시 보드를 만드는 코드를 작성하세요.
- LinkedList를 구현하세요.
- Stack을 구현하세요.
- 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.
- Queue를 구현하세요.

---------------------------------
# 제어문

프로그램의 흐름을 제어할 수 있도록 도와주는 실행문이다.
제어문 종류는 선택문과 반복문이 있는데 선택문에는 if문, switch문이 있고 반복문에는 for문, while문, do-while문이 있다. 

- 선택문 : if, if-else, switch
- 반복문 : for, while, do-while
- 분기문 : break, continue, return

## 선택문

의사결정을 할때 쓰인다. 어느 코드블럭을 실행해야 할지 선택해야 할때 쓰인다.

#### if문

```
if (condition) { /* code */ }
```
condition이 true일 때 code블럭 실행

#### if-else문

```
if (condition) { /* code1 */ }
else { /* code2 */ }
```

condition이 true이면 code1 실행, 아니면 code2 실행

#### switch문

변수나 식의 값이 다양한 분기를 통해 프로그램의 실행 흐름을 제어할 수 있게 해준다.  break 키워드를 이용해 각 분기를 마친다. week3에서 정리하였으므로 넘어간다.

## 반복문

```
while (expression) { statement; }
do { statement; } while (expression)
for (초기값; 조건; 방향&간격) { statement; }
for (<type> <instance>: <type-iterable>) { statement; }
```

## 분기문

- break : while, for 또는 switch문을 끝낼 수 있는 구문이다.
- continue : loop문에서 continue문이 실행되면 그 아래 코드들은 스킵한 뒤에 다음 스텝의 루프를 실행한다.

---------------------------------
# 과제

## JUnit 5

JUnit은 JVM 상에서 사용 가능한 단위 테스트 프레임워크이며 JUnit 5는 이전 JUnit 버전들과 다르게 크게 **세가지 서브 프로젝트의 모듈로 구성**되어 있다.

`JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage`
- JUnit Platform: JVM 상에서 테스팅 프레임워크를 실행시키기 위한 기초적인 역할을 담당
  - 테스트를 하기 위한 TestEngine APi 제공
  - JUnit4 (하위버전) 기반 테스트 제공
- JUnit Jupiter:  JUnit5 에서 테스트 및 확장(extension)에 대한 프로그래밍 모델과 확장 모델의 조합
- JUnit Vintage: JUnit3과 JUnit4 를 실행하기 위한 TestEngine 을 제공

## JUnit 5.x.x 설정

```
test { 
    useJUnitPlatform() 
}
```
build.gradle에 Junit Platform을 사용하여 테스트를 할 수 있도록 설정한다.

```
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.3.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.3.1'
}
```
build.gradle에 JUnit Dependency를 추가한다. 이 때 JUnit5에서는 API 부분과 실행을 가능하도록하는 런타임 플랫폼이 구분되어져 있으므로 `JUnit API`와 Runtime Platform인 `Jupiter API` 두가지 dependency를 추가한다.

## 어노테이션
Jupiter에서는 테스트와 확장된 기능을 제공하기 위해 여러가지 어노테이션을 제공한다.

| Annotaion              | 설명                                                         |
| ---------------------- | ------------------------------------------------------------ |
| @Test                  | 테스트 메소드임을 알림<br />Junit 4와는 다르게 속성을 정의 X<br />이는 Jupiter에선 이미 해당 어노테이션들이 존재하기 때문 |
| @ParameterizedTest     | 여러가지 매개변수를 통해 다양한 테스트 진행                  |
| @RepeatedTest          | 반복 횟수만큼 테스트를 진행                                  |
| **@TestFactory**       | 동적 테스트를 위한 테스트 팩토리                             |
| @TestTemplate          | 일반 테스트가 아닌 테스트 케이스의 템플릿                    |
| @TestMethodOrder       | 테스트 메서드의 실행 순서를 구성하는데 사용(Junit 4의 @FixMethodOrder와 유사) |
| @TestInstance          | 테스트 인스턴스 생명주기를 구성하는데 사용                   |
| **@DisplayName**       | 테스트 클래스 혹은 메소드에 대한 이름을 선언                 |
| @DisplayNameGeneration | 테스트 클래스에 대한 Display name generator를 선언           |
| **@BeforeEach**        | 현재 클래스에서 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 적힌 **각각의** 메소드들 보다 먼저 실행<br />(JUnit 4의 @Before와 동일) |
| **@AfterEach**         | 현재 클래스에서 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 적힌 **각각의** 메소드들 보다 나중에 실행<br />(JUnit 4의 @After와 동일) |
| @BeforeAll             | 현재 클래스에서 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 적힌 **모든**  메소드들 보다 먼저 실행<br />(JUnit 4의 @BeforeClass와 동일) |
| @AfterAll              | 현재 클래스에서 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 적힌 **모든** 메소드들 보다 나중에 실행<br />(JUnit 4의 @AfterClass와 동일) |
| **@Nested**            | 중첩된 테스트 클래스임을 알림<br />각 클래스의 테스트 인스턴스 생명주기를 사용하지 않는 한 @BeforeAll과 @AfterAll 메소드는 사용 X |
| **@Tag**               | 테스트 필더링을 위한 테그를 선언하는데 사용                  |
| **@Disabled**          | 테스트 클래스 혹은 메소드를 비활성하는데 사용(JUnit 4의 @Ignore와 유사) |
| @Timeout               | 주어진 시간을 초과할 경우, 테스트 실패를 나타내기 위해 사용  |
| **@ExtendWith**        | 확장을 선언적으로 등록하는데 사용                            |
| @RegisterExtension     | 필드를 통해 프로그래밍 방식으로 확장을 등록하는데 사용       |
| @TempDir               | 필드 주입 또는 매개변수 주입을 통해 임시 디렉토리를 제공하는데 사용 |

## 주장과 가정

### Assertions
Assertion은 가정 설정문이라고 할 수 있으며 이를 통해 해당 로직이 정확한지 테스트해보는 것이다. Jupiter에서는 기존 버전에 존재했던 Assertion 메서드를 포함하고 **람다와 함께 사용하기위한 추가적인 메서드를 제공**한다.

- **다양해진 assert 방식**
  - assertThat → assertThrows, assertEquals, assertTimeout, assertNotNull 등..
- **한 번에 여러 test를 실행 가능**
  - 기존에 하나의 테스트가 실패하면 더 이상 진행되지 않는 Junit 4의 문제점을 해결
    ```
    assertAll( 
               () -> assertNotNull(), 
               () -> assertEquals(), 
               () -> assertTrue(), 
               () -> assertTimeout(), 
    );
    ```

예제를 통해 사용 방법을 좀 더 알아보자
```
// 람다 사용
@Test
void lambdaExpressions() {
    assertTrue(Stream.of(1, 2, 3)
      .stream()
      .mapToInt(i -> i)
      .sum() > 5, () -> "Sum should be greater than 5");
}

// assertAll 사용 
 @Test
 void groupAssertions() {
     int[] numbers = {0, 1, 2, 3, 4};
     assertAll("numbers",
         () -> assertEquals(numbers[0], 1),
         () -> assertEquals(numbers[3], 3),
         () -> assertEquals(numbers[4], 1)
     );
 }

// 의존
@Test
void dependOnAssertions() {
  assertAll(() -> {
             assertAll(() -> assertTrue(),
                       () -> assertTrue());
           },
           () -> {
             assertAll(() -> assertEquals(),
                       () -> assertEquals());
           });
}

// 예외 테스트
@Test
void shouldThrowException() {
    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
      throw new UnsupportedOperationException("Not supported");
    });
    assertEquals(exception.getMessage(), "Not supported");
}

// 예외 테스트
@Test
void assertThrowsException() {
    String str = null;
    assertThrows(IllegalArgumentException.class, () -> {
      Integer.valueOf(str);
    });
}
```

### Assumptions
Assumption은 테스트를 진행할지 안할지에 대해 테스터가 작성한 가정을 기반으로 선택된다. Assertion과 똑같이 정적 메서드로 정의되어 있다.

```
@Test
void testOnlyOnDev() {
  assumeTrue("DEV".equals(System.getenv("ENV")));
  
  DEV 환경에서만 테스트할 코드;
}

@Test
void testAllEnv() {
  assumeTrue("DEV".equals(System.getenv("ENV")),
             () -> {
               DEV 환경에서 테스트할 코드;
             });

  모든 환경에서 테스트할 코드;
}
```

---------------------------------

## live-study 대시 보드 구현

- 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
- 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
- Github 자바 라이브러리를 사용하면 편리합니다.
- 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 - 테스트를 하시면 더 자주 테스트할 수 있습니다.

#### Github API
공식 문서에 따르면 GitHub의 도메인 모델(GHUser, GHRepository 등)에 해당되는 객체가 존재한다. GHUser와 GHRepository 객체를 생성하여 유저와 레파지토리 관련 정보를 얻을 수 있다고 한다.

#### Github API의 주요 클래스

- **GitHubBuilder**
  - withOAuthToken() 메소드에 Github에서 발급받은 personal token을 넘겨 `Github 인스턴스`를 반환받을 수 있다.
- GitHub
  - getRepository() 메소드에 원하는 repository의 {owner/repo 이름} 문자열을 넘겨 `GHRepository 인스턴스`를 반환받을 수 있다.
- **GHRepository**
  - getIssues() 메소드에 GHIssueState.ALL과 같은 이슈의 상태값을 넘겨 해당 repository의 issue들을 필터링해서 `List<GHIssue> 인스턴스`로 반받을 수 있다.
- **GHIssue**
  - getComment() 메소드를 호출해 해당 GHIssue 인스턴스의 comment들을 `List<GHIssueComment> 인스턴스`로 반환받을 수 있다.
- **GHIssueComment**
  - getUser() 메소드를 호출해 해당 GHIssueComment 인스턴스의 작성자 정보를 `GHUser 인스턴스`로 반환받을 수 있다.
- **GHUser**
  - getLogin() 메소드를 호출해 해당 GHUser 인스턴스의 login id를 `String 인스턴스`로 반환받을 수 있다.

[Implementation](https://github.com/Jaeeun1083/Study_Java/blob/master/%EC%8A%A4%ED%84%B0%EB%94%94%20%ED%95%A0%EB%9E%98/%EB%B0%95%EC%9E%AC%EC%9D%80/week/main/java/livestudy/week4/github/GithubDashBoard.java)

---------------------------------
## LinkedList를 구현하세요.

- 정수를 저장하는 ListNode 클래스를 구현하세요.
- ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
- ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
- boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.

#### LinkedList란?
배열과 비슷하게 데이터들의 묶음을 나타낼 때 사용한다. 배열의 경우 연속적인 공간 안에 데이터를 저장하고 위치를 통해 데이터에 접근했다면 LinkedList는 하나의 노드 안에 데이터와 그 다음 노드를 가리키는 주소 값을 가지고 있어 다음 노드로 탐색이 가능하다.

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20210409184741/HowtoImplementGenericLinkedListinJava.jpg">

위 그림과 같이 Data + Next(다음 노드 위치)를 하나로 묶고 이를 Node라고 한다. 하나의 노드에서 다음 노드의 위치를 또 그 다음 노드의 위치를 표시하여 꼬리에 꼬리를 무는 형태이다.

#### 종류
LinkedList의 종류는 노드를 어떻게 구성하느냐에 따라 나뉜다.

- 단순 연결 리스트
  - 노드에서 다음 노드의 위치만 저장
- 원형 연결 리스트
  - 마지막 노드의 다음 노드 위치를 null이 아닌 맨 처음 노드를 가리키게 하여 원형의 형태를 가짐
- 이중 연결 리스트
  - 하나의 노드에 이전 노드와 다음 노드의 위치를 둘 다 저장

[Implementation](https://github.com/Jaeeun1083/Study_Java/blob/master/%EC%8A%A4%ED%84%B0%EB%94%94%20%ED%95%A0%EB%9E%98/%EB%B0%95%EC%9E%AC%EC%9D%80/week/main/java/livestudy/week4/structure/LinkedList.java)

[Test](https://github.com/Jaeeun1083/Study_Java/blob/master/%EC%8A%A4%ED%84%B0%EB%94%94%20%ED%95%A0%EB%9E%98/%EB%B0%95%EC%9E%AC%EC%9D%80/week/test/java/livestudy/week4/structure/LinkedListTest.java)

---------------------------------
## Stack을 구현하세요.

- int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

#### 스택이란?
한 쪽 끝에서만 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형태의 자료 구조이다.
즉, 첫번째로 들어간(push) 것은 제일 마지막에 꺼낼(pop) 수 있다.

#### 스택 연산
LIFO를 따르므로 가장 최근에 스택에 추가한 항목이 가장 먼저 제거될 항목이다.

- pop() : 스택에서 가장 위에 있는 항목을 제거한다.
- push(data) : data 하나를 스택의 가장 윗 부분에 추가한다.
- peek() : 스택의 가장 위에 있는 항목을 반환한다.
- isEmpty() : 스택이 비어있을 때 true를 반환한다.

[Implementation](https://github.com/Jaeeun1083/Study_Java/blob/master/%EC%8A%A4%ED%84%B0%EB%94%94%20%ED%95%A0%EB%9E%98/%EB%B0%95%EC%9E%AC%EC%9D%80/week/main/java/livestudy/week4/structure/Stack.java)

[Test](https://github.com/Jaeeun1083/Study_Java/blob/master/%EC%8A%A4%ED%84%B0%EB%94%94%20%ED%95%A0%EB%9E%98/%EB%B0%95%EC%9E%AC%EC%9D%80/week/test/java/livestudy/week4/structure/StackTest.java)
