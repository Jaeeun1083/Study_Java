# 열거형 클래스 enum

어떤 클래스가 상수만으로 만들어져 있을 경우 class로 선언하는 것이 아닌 열거형으로 선언을 하면 이 객체는 상수의 집합이라는 것을 명시적으로 나타낸다.

열거형이 가지는 값만 관리하는 것이 아니라 타입까지 관리하기 때문에 논리적인 오류를 줄일 수 있다.

### 특징
- 모든 Java의 enum들은 암시적으로 java.lang.Enum Class를 확장한다.
- 정의된 상수 하나당 하나의 인스턴스가 생성된다.
- 데이터를 비교할 때 실제 값과 함께 타입을 체크한다.
- 메서드와 필드를 추가하고 인터페이스를 구현할 수 있다.

### 정의 하는 방법
- 기본적인 열거형의 정의
    ```
    enum 열거형이름 { 
        상수명1, 상수명2, ... 
    }

    enum Day { 
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; 
    }
    ```
    - enum 클래스는 일반 클래스와 마찬가지로 컴파일 할 때 생성자를 자동으로 만들어준다.

-  데이터와 메소드가 있는 열거형의 정의
    ```
    public enum OverTimeValue {
        THREE_HOUR(18000),
        FIVE_HOUR(30000),
        WEEKEND_FOUR_HOUR(40000),
        WEEKEND_EIGHTTHREE_HOUR(60000),
        
        private final int amount;

        OverTimeValue(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    ### 사용 ###
    public class OberTimeManager {
        public static void main(String[] args) {
            OverTimeValue value = OverTimeValue.FIVE_HOUR;
            System.out.println(value);
            System.out.println(value.getAmount());
        }
    }

    ### 결과 ###
    FIVE_HOUR
    30000
    ```
    - 각 상수들의 값이 지정된 것을 볼 수 있다.
    - 상수 아래에는 변수가 final로 선언되어 있다. 이 변수는 그 다음 줄에 있는 생성자에서 매개 변수로 넘겨받은 값을 할당할 때 사용된다.
    - enum 클래스도 생성자를 사용할 수는 있지만 enum 클래스의 생성자는 아무것도 명시하지 않는 package-private ()과 private만 접근제어자로 사용할 수 있다. 
    - public 이나 protected를 생성자로 사용해서는 안된다. 즉 각 상수를 enum 클래스 내에서 선언할 때에만 이 생성자를 사용할 수 있다.  

### java.lang.Enum

- enum 클래스는 java.lang.Enum 클래스를 상속 받는다. Enum 클래스의 생성자는 다음과 같이 선언되어 있다.

    | 접근 제어자 | 메소드 | 설명 |
    | -- | -- | --|
    | protected | Enum(String name, int ordinal) | 컴파일러에서 자동으로 호출되도록 해놓은 생성자이다. 사용자가 이 생성자를 호출할 수 없다. |
  - name: enum 상수의 이름
  - ordinal : enum의 순서 (상수 선언 순서대로 0부터 증가)

### 제공 메소드

<!-- Enum 클래스의 부모 클래스는 Object 클래스이므로 Object 클래스의 메소드는 모두 사용할 수 있지만 Enum 클래스는 개발자들이 Object 클래스 중 4개의 메소드를 오버라이딩하지 못하도록 막아놓았다.

- clone() : 객체 복제
- finalize() : GC 발생 시 처리하기 위한 메소드
- hashCode() : int 타입의 해시 코드 값 리턴
- equls() : 두 객체가 동일한지 확인

이 외에 Enum 클래스에서 선언되어 있는 메소드들을 살펴보자 -->

#### compareTo (E e)
- 상수의 ordinal 값을 이용하여 두 개의 상수를 비교하는 메서드이다. 반환 값은 int이다.

#### values()
- 정의된 모든 상수를 배열에 담아 반환한다.
    ```
    OverTimeValue[] valueList = OverTimeValue.values();
    for (OverTimeValue value : valueList) {
        System.out.println(value);
    }

    ### 결과 ###
    THREE_HOUR
    FIVE_HOUR
    WEEKEND_FOUR_HOUR
    WEEKEND_EIGHTTHREE_HOUR
    ```

#### valueOf()
- 정의된 상수와 변수로 넘긴 문자열을 비교한 뒤 그 결과를 반환한다.
- 전달된 문자열과 동일한 상수가 없을 경우 NPE가 발생한다.
    ```
    value = OverTimeValue.valueOf("THREE_HOUR");

    // NPE
    value = OverTimeValue.valueOf("aaa");
    ```