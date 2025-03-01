# 연산자

`학습할 것`

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자

---------------------------------
### 용어 정의

- 프로그램에서 데이터를 처리하여 결과를 산출하는 것을 연산(operation)이라고 한다.
- 연산에 사용되는 표시나 기호를 연산자(operator)라고 한다.
- 연산의 대상이 되는 데이터는 피연산자(operand)라고 한다.
- 연산자와 피연산자로 연산의 과정을 기술한 것을 연산식(expressions)이라고 한다.

### 연산자의 종류

| 종류 | 연산자 | 결과 값 | 설명 |
|-----|-----|-----|-----|
| 산술 연산자 | + , - , * , / , % | 숫자 | 사칙연산 및 나머지 계산 |
| 증감 연산자 | ++ , -- | 숫자 | 1만큼 증가/감소 |
| 비트 연산자 | & ,  \| , ^ , ~ | 숫자, boolean | 비트 NOT, AND, OR, XOR 연산 |
| 시프트 연산자 | >> , << , >>> | 숫자 | 비트를 좌측/우측으로 밀어서 이동 |
| 관계(비교) 연산자 | > , < , >= , <= , == , != | boolean | 값의 비교 |
| 논리 연산자 | && , \|\| , ! | boolean | 논리적 NOT, AND, OR 연산 |
| 조건(삼항) 연산자 | ? , : | 다양 | 조건식에 따라 A 또는 B 중 하나를 선택 |
| 대입 연산자 | = , *= , /= , %= , += , -= | 다양 | 우변의 값을 좌변의 변수에 대입 |

---------------------------------
# 산술 연산자

자바에서 산술 연산은 사칙 연산 (덧셈, 뺄셈, 곱셈, 나눗셈)과 나머지 연산이 있다.
산술 연산자는 정수, 부동소수점, 문자열 등 boolean 타입을 제외한 모든 프리미티브 타입에서 사용이 가능하다. 피연산자들 중 부동 소수점이 있다면 부동소수점 산술이 되고 아니면 정수 산술이 된다.

### 더하기 ( `+` )
`+` 연산자는 기본적으로 두 수를 더하는 연산이나 문자열을 연결할 수도 있다. 만약 +의 피연산자 중 문자열이 있다면 나머지 피연산자도 문자열로 변환 된다.

``` 
int num1 = 10;
int num2 = 3;

int sum1 = num1 + num2;
System.out.println(sum1); // 13

String str = "Hello ";
String sum2 = str + num1;
System.out.println(sum2); // Hello l10
```

### 빼기 ( `-` )
`-` 연산자는 첫번째 피연산자에서 두번째 피연산자를 빼는 연산자이다. 더하기 연산처럼 문자열 연산은 불가능하다.
``` 
int num1 = 10;
int num2 = 3;

int sum1 = num1 - num2;
System.out.println(sum1); // 7

String str = "Hello ";
String sum2 = str - num1; // 컴파일 에러
```

### 곱하기 ( `*` )
`*` 연산자는 두 피연산자를 곱한다. 마찬가지로 문자열 연산은 불가능하다.
``` 
int num1 = 10;
int num2 = 3;

int sum1 = num1 * num2;
System.out.println(sum1); // 30

String str = "Hello ";
String sum2 = str * num1; // 컴파일 에러
```

### 나누기 ( `/` )
`/` 연산자는 첫번째 피연산자를 두번째 피연산자로 나눈다. 두 피연산자가 모두 정수라면 결과도 정수이며 나머지는 내림으로 없어진다. 피연산자 중 부동소수점이 있다면 결과도 부동소수점이다.

정수를 0으로 나눌 경우 `ArithmeticException`이 발생한다.
``` 
System.out.println(10 / 3); // 3
System.out.println(10 / 3.0); // 3.33333335
```

### 나머지 ( `%` )
`%` 연산자는 첫번째 피연산자를 두번째 피연산자로 나누고 남은 나머지를 정수로 리턴한다. 부동소수점에도 사용이 가능하고 이러한 경우 부동소수점으로 리턴한다.
``` 
System.out.println(10 % 4); // 2
System.out.println(-10 % 4); // -2 (첫번째 피연산자의 부호와 결과의 부호 동일)
System.out.println(10 % -4); // 2
```

---------------------------------
# 비트 연산자

비트 연산자와 시프트 연산자는 개별 비트를 조작하는 연산자이다. 비트 연산을 이해하기 위해서는 이진수와 음의 정수를 나타내는데 사용되는 2의 보수를 알아야한다.

부동소수점, boolean, 배열, 객체 등을 피연산자로 사용할 수 없다.

### 비트 보수 ( `~` )
`~` 연산자는 비트 반전 혹은 비트 NOT 연산자라고 한다.
각 비트를 반전시켜 1을 0으로, 0을 1로 변환한다.
```
int i = ~1; 
byte b = ~1;

System.out.println(i); // -2 (바이너리 값 : 0b11111111_11111111_11111111_11111110)
System.out.println(b); // -2 (바이너리 값 : 0b11111110)
```
둘다 출력해보면 -2가 나오지만 바이너리 값은 다르다.
int는 32bit이고 byte는 8bit이기 때문이다.

### AND (`&`)
`&`연산자는 두 정수 피연산자를 AND 연산한다. (비트곱)
비트곱은 두 피연산자의 해당 비트가 모두 1일때만 1 아니면 0을 리턴한다
```
int num1 = 10; // (바이너리 값 : 0b00001010)
int num2 = 20; // (바이너리 값 : 0b00010100)
System.out.println( num1 & num2 ); // 0 (바이너리 값 : 0b00000000)
```

### OR (`|`)
`|` 연산자는 두 정수 피연산자의 OR 연산을 한다. (비트합)
```
int num1 = 10; // (바이너리 값 : 0b00001010)
int num2 = 20; // (바이너리 값 : 0b00010100)
System.out.println( num1 | num2 ); // 30 (바이너리 값 : 0b00011110)
```

### XOR (`^`)
`^` 연산자는 두 정수 피연산자의 XOR 연산을 한다. (exclusive OR)
두 피연산자의 해당 비트가 같으면 0, 다르면 1을 리턴한다.
```
int num1 = 10; // (바이너리 값 : 0b00001010)
int num2 = 20; // (바이너리 값 : 0b00010100)
System.out.println( num1 ^ num2 ); // 30 (바이너리 값 : 0b00011110)
```

### 왼쪽 시프트 연산 (`<<`)
`<<`연산자는 비트를 왼쪽으로 두번째 피연산자로 제시된 비트 수만큼 이동시킨다.
시프트 될 때 가장 된쪽 비트는 삭제되고 가장 오른쪽 비트는 0으로 채워진다.
```
int num = 10; // (바이너리 값 : 0b00001010)
int result1 = num << 1; // 20 (바이너리 값 : 0b00010100)
int result2 = num << 2; // 40 (바이너리 값 : 0b00101000)
```

### 오른쪽 시프트 연산 (`>>`)
`>>`연산자는 비트를 오른쪽으로 두번째 피연산자로 제시된 비트 수만큼 이동시킨다.
시프트 될 때 가장 오른쪽 비트는 삭제되고 가장 왼쪽쪽 비트는 0으로 채워진다. 음수인 경우는 1이 채워진다.
```
int num1 = 10; // (바이너리 값 : 0b00001010)
int result1 = num1 >> 1; // 20 (바이너리 값 : 0b00000101)
int result2 = num1 >> 2; // 40 (바이너리 값 : 0b00000010)

int num2 = -10; // (바이너리 값 : 0b1110110)
int result3 = num2 >> 1; // -5 (바이너리 값 : 0b1111011)
int result4 = num2 >> 2; // -2 (바이너리 값 : 0b1111101)
```

### unsigned 오른쪽 시프트 연산 (`>>>`)
오른쪽 시프트 연산과 비슷하지만 피연산자의 부호와 상관없이 왼쪽 비트는 0으로 채워진다.

---------------------------------
# 관계 연산자 (비교 연산자)

- 같거나 같지 않음을 평가하는 비교 연산자
- 크고 작은 관계를 평가하는 관계 연산자
- 이 연산들의 결과 값은 항상 부울형(true 또는 false)의 형태이기 때문에 if문과 같은 제어문이나 for문 같은 반복문장에 자주 사용된다.

| 연산자 | 기능 | 사용법 | 사용 설명 |
| :---: |-----|-----|-----|
| `>` | 보다 크다 | op1 > op2 | op1이 op2보다 큰 경우 true 아니면 false |
| `>=` | 보다 크거나 같다. | op1 >= op2 | op1이 op2보다 크거나 같은 경우 true 아니면 false |
| `<` | 보다 작다 | op1 < op2 | op1이 op2보다 작은 경우 true 아니면 false |
| `<=` | 보다 작거나 같다 | op1 <= op2 | op1이 op2보다 작거나 같은 경우 true 아니면 false |
| `==` | 같다 | op1 == op2 | op1과 op2이 같은 경우 true 아니면 false |
| `!=` | 같지 않다 | op1 != op2 | op1과 op2이 같지 않은 경우 true 아니면 false |

---------------------------------
# 논리 연산자
비트 연산과 비슷하지만 피연산자가 boolean 타입의 논리 값이다.

- !는 논리적인 부정을 뜻하며 true를 false, false를 true로 바꿔준다.
- &&는 첫번째 피연산자의 결과가 false라면 두번째 피연산자를 평가하지 않고 false를 리턴한다.
- ||는 첫번째 피연산자의 결과가 true라면 두번째 피연산자를 평가하지 않고 true를 리턴한다. 

```
boolean myTrue = true;
boolean myFalse = false;

if (myTrue & myFalse) System.out.println("myTrue & myFalse 는 true"); 
if (myTrue | myFalse) System.out.println("myTrue | myFalse 는 true"); // 출력
if (myTrue && myFalse) System.out.println("myTrue && myFalse 는 true");
if (myTrue || myFalse) System.out.println("myTrue || myFalse 는 true"); // 출력

if (!myFalse) System.out.println("!myFalse 는 true"); // 출력
```
---------------------------------
# instanceof
객체또는 배열 값을 어떠한 참조 유형에 맞는 값인지를 평가하는 연산자이다. 만약 null을 평가한다면 항상 false가 리턴된다.
만약 평가 결과가 true라면 **비교된 참조 유형으로 안전하게 캐스팅하고 할당할 수 있다**는 것을 의미한다.

```
"str" instanceof String // true
null instanceof String // false

Obejct o = new int[]{1, 2, 3};
o instanceof int[] // true

// safety casting
if (obj instance of MyClass) {
    MyClass c = (MyClass) obj;
}

// Primitive type은 사용할 수 없다.
i instanceof int // 컴파일 에러
```

---------------------------------
# assignment(=) operator
오른쪽의 피연산자를 왼쪽의 피연산자의 값으로 할당할 때 사용한다. 메모리에 값을 저장하거나 할당한다는 의미이다.

---------------------------------
# 화살표(->) 연산자 (람다 표현식)
자바8부터 도입된 연산자로 람다 표현식이라고 하며 메서드 본문에 해당 실행 가능한 자바 코드의 익명 컬렉션이다.

메서드 파라미터 목록, 연산자, 코드 블럭 순으로 구성된다.
코드 블럭이 한 문장으로 끝난다면 중괄호는 생략할 수 있다.
```
Runnable r = () -> {
    sout
}
```

---------------------------------
# 3항 연산자
if -else 문장을 연산자로 표현할 수 있고 조건에 따라 결과를 리턴할 수 있다.

` 조건 ? 조건이 참일 때 실행 : 조건이 거짓일 때 실행 `
```
System.out.println(1 > 3 ? "true 리턴해줘" : "false 리턴해줘"); // false 리턴해줘
System.out.println(5 > 3 ? "true 리턴해줘" : "false 리턴해줘"); // true 리턴해줘
```

---------------------------------
# 연산자 우선 순위

| 우선 순위 | 연산자 | 동작 |
| :----: | :----: | :----: |
| 1 | ( ),[ ] | 요소 접근 |
| 2 | !, ~, ++, -- | 비트 보수, 부정 연산, 후위 전위 증감 |
| 3 | *, /, % | 곱하기, 나누기, 나머지 |
| 4 | +, - | 더하기, 빼기 |
| 5 | <<, >>, >>> | 왼쪽 시프트, 오른쪽 시프트, 부호없는 오른쪽 시프트 |
| 6 | <, <=, >, >= | 작음, 작거나 같음, 큼, 크거나 같음 |
| 7 | ==, != | 같음, 같지 않음 |
| 8 | & | AND |
| 9 | ^ | XOR |
| 10 | \| | OR |
| 11 | && | AMD |
| 12 | \|\| | OR |
| 13 | ? : | 삼항 연산자 |
| 14 | =, +=, -=, *=, /=, <<=, >>=, &=, ^=, ~= | 대입 연산자 |
| 15 | -> | 람다 표현식 |

---------------------------------
# (optional) Java 13. switch 연산자

swtich 연산자는 조건에 따라 분기해야할 내용이 많아질 경우, 가독성과 실행 속도 측면에서 사용할 수 있다.

```
int result;
switch (str) {
    case a:
        result = 1;
        break;
    case b:
        result = 2;
        break;
    case c:
        result = 3;
        break;
};
return result;
```
위의 switch 문의 사용방식이 전통적인 switch문의 문법이다.

이는 몇가지 문제점이 있는데 **break 키워드 쓰는 것을 잊었을 경우 그 아래있는 코드 블럭이 실행**된다는 것과 **하나의 case에는 하나의 값만 비교**할 수 있다는 것이다.
자바 12, 13부터는 위 방식의 문제점을 개선한 새로운 기능들이 추가되었다.

- 자바12부터는 
  - **쉼표( , )를 사용**하여 여러 케이스를 한 줄에 나열할 수 있다. 
  - **화살표 ( -> )를 사용**하여 결과를 반환할 수 있으며 break 키워드를 사용하지 않아도 된다.
- 자바13부터는 
  - **yield 키워드를 사용**하여 switch 결과를 반환할 수 있다.
  - **scope**를 사용하여 case-level의 scope를 이용할 수 있다.

#### 쉼표 사용
```
private static int switchWithMultiCase(String str) {
    int result;
    switch (str) {
        case "a":
            result = 1;
            break;
        case "b","c"
            result = 2;
            break;
    };
    return result;
}
```

#### 화살표 사용
switch문과 함께 화살표 연산자(->)를 사용할 수 있다. 화살표 연산자를 사용하면 **break은 사용할 필요가 없다**.

화살표 연산자의 우변에 올 수 있는 것은 다음과 같다.

- Statement / expression
- throw statement
- {} block

```
private static int switchWithArrow(String str) {
    int result = switch (str) {
        case "a", "b" -> 1;
        case "c" -> 2;
        case "d", "e", "f" -> 3;
        default -> -1;
        };
    return result;
}
```

#### yield 키워드 사용
Java 13부터는 yield라는 키워드를 통해 switch문이 값을 반환할 수 있게 되었다. 
따라서 switch문을 식으로도 사용이 가능하게 되었다. **yield 키워드가 값을 반환**하면서 switch문을 끝내므로 **break은 사용할 필요가 없다**.
```
private static int switchWithYield(String str) {
    int result = switch (str) {
        case "a", "b":
            yield 1;
        case "c":
            yield 2;
        case "d", "e", "f" :
            yield 3;
        default:
            yield -1;
    };
    return result;
}
```

#### scope 사용
Java 13부터 switch문의 각 case에 {}을 쓸 수 있게되어, case-level의 scope를 사용할 수 있게 되었다.
```
private static int switchWithScope(String str) {
    int result;
    switch (str) {
        case "a": {
            result = 1;
            break;
        }
        case "b": {
            result = 2;
            break;
        }
        case "c", "d": {
            result = 3;
            break;
        }
    };
    return result;
}
```