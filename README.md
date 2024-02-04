# 👾 프로젝트 소개

포켓몬스터 게임은 애니메이션 '포켓몬스터'을 모티브로 제작되었으며, 팀원들과 배운 내용을 기반으로 자바에 대한 숙련도와 팀원과의 협업 감각을 기르기 위해 팀 토이 프로젝트를 진행하였습니다.

이 게임에서는 다양한 포켓몬의 매력을 살린 전투를 경험할 수 있으며, 상대 포켓몬을 포획하여 내 캐릭터를 늘릴 수도 있습니다.

### 🐶 팀원

<div align="center">
    
|[박고은](https://github.com/goeunpark123) | [배성민](https://github.com/mini-xi) | [이예원](https://github.com/onelee521) | [장민석](https://github.com/ms1011) | [정우진](https://github.com/Wrinkk) | [한소혜](https://github.com/Sosohy)|
|------------------------------------------|--------------------------------------|------------------------------------------|-----------------------------------|-------------------------------------|------------------------------------------|

</div>


# 🪄 기능

- 게임메뉴 선택 기능
- 포켓몬 배틀 실행
- 시작 포켓몬과 상대 포켓몬 선정 기능
- 포켓몬 공격 및 데미지 계산
- 포켓몬 각 속성 스킬 기능
- 낮은 확률로 전설의 포켓몬 만나는 기능
- 트레이너
    - 싸우기
    - 도망가기
    - 가방열기
        - 회복약 사용 및 포켓몬 체력 회복
        - 포켓몬볼 던지기

# 🙌 실행화면

<details>
         <summary><b> 트레이너 포켓몬 및 적 포켓몬 선정</b></summary>
         <p><img src="https://github.com/4goda/pokemon/blob/main/capture/%ED%8A%B8%EB%A0%88%EC%9D%B4%EB%84%88_%ED%8F%AC%EC%BC%93%EB%AA%AC_%EC%A0%81_%ED%8F%AC%EC%BC%93%EB%AA%AC_%EC%84%A0%ED%83%9D.png"/></p>
</details>
<details>
         <summary><b>포켓몬 공격 - 기술 사용</b></summary>
         <p><img src="https://github.com/4goda/pokemon/blob/main/capture/%EA%B8%B0%EC%88%A0%EC%82%AC%EC%9A%A9.png"/></p>
</details>
<details>
         <summary><b>회복약 사용</b></summary>
         <p><img src="https://github.com/4goda/pokemon/blob/main/capture/%ED%9A%8C%EB%B3%B5%EC%95%BD_%EC%82%AC%EC%9A%A9.png"/></p>
</details>
<details>
         <summary><b>포켓몬 볼 사용</b></summary>
         <p><img src="https://github.com/4goda/pokemon/blob/main/capture/%ED%8F%AC%EC%BC%93%EB%AA%AC%EB%B3%BC_%EC%82%AC%EC%9A%A9.png"/></p>
</details>


# 🖥️ 패키지/클래스

## aggregate

`Attribute` : 각 포켓몬의 속성을 정의한 Enum 클래스

`Battle` : 배틀 시작 및 종료, 턴 체크 등 배틀과 관련한 속성과 메소드를 정의한 클래스

`Pokemon` : 배틀에 필요한 기본적인 포켓몬 속성을 정의한 추상 클래스

`Charmander / Chikorita / Pikachu / Squirtle / Mewtwo` : `Pokemon` 클래스를 상속 받아 각 캐릭터에 맞는 스킬을 추가한 캐릭터 클래스

`Game` : 기본적인 게임 시스템 속성과 메소드를 정의한 클래스

`Skill` : 스킬에 관련된 속성과 이를 관리하기 위한 메소드를 정의한 클래스

`Trainer` : 트레이너와 관련된 정보(가방, 보유한 포켓몬 등)를 관리하기 위한 클래스

`TrainerBag` : 트레이너가 보유한 몬스터볼과 회복약을 관리하기 위한 클래스


## DB

`Trainersave` : 트레이너가 현재까지 진행한 스토리를 저장한 DB (미완성)

`Skill` :  포켓몬들이 지닌 모든 스킬들을 저장해둔 DB

`Pokemon` : 포켓몬에 대한 Type, 체력,  등장 소리, 이름을 저장해둔 DB

## Repository

`GameRepository` : 게임 사운드, 해상도, 조작방향 설정을 저장해둔 클래스 (미완성)

`PokemonRepository` :  포켓몬에 대한 Type, 체력,  등장 소리, 이름을 DB로 저장 및 로딩해 반환해주는 클래스

`SkillRepository` : 포켓몬들이 지닌 모든 스킬(일반, 속성) 들을 DB로 저장 및 로딩해 반환해주는 클래스

`TrainerRepository` : 트레이너가 현재까지 진행한 스토리를 DB로 저장하는 클래스 (미완성)

## Exception

`ChoiceException` : 사용자가 선택지에 없는 번호를 입력했을 경우에 발생하는 예외 처리 하는 기능

`IllegalNameException` :  사용자가 한글이나 영어 이외의 문자가 포함된 트레이너 이름을 입력했을 경우에 발생하는 예외 처리하는 기능

`NotEnoughHealItem` :  사용자가 회복약을 모두 소진하고서 회복약을 다시 사용하려는 경우에 발생하는 예외 처리하는 클래스

`NotEnoughMonsterBall` : 사용자가 몬스터볼을 모두 소진하고서 몬스터볼을 다시 사용하려는 경우에 발생하는 예외 처리하는 클래스

## Run

`Application` : Controller로, 게임을 실행시켜서 작동시키는 클래스

`BattlePage` : 포켓몬 배틀이 이루어지는 클래스

## Service

`BattleService` :  포켓몬 공격 및 배틀 결과에 대한 기능을 실행하는 클래스

`GameService` :   starting포켓몬을 선택하고 적 포켓몬을 선정하는 기능을 위한 클래스 

`SkillService` : 포켓몬의 스킬과 스킬에 따른 랜덤 데미지를 발생시키는 기능을 위한 클래스

`TrainerService` : 트레이너 명령과 공격할 스킬, 아이템 사용 등의 기능을 실행하기 위한 클래스



# 🧑‍🤝‍🧑 회고

|&nbsp;&nbsp;팀&nbsp;원&nbsp;&nbsp;&nbsp;|회고록|
|:---:|---|
|박고은|  |
|배성민|  |
|이예원|  |
|장민석|  |
|정우진| 자바 정규 수업이 끝난 후, 팀원들과 함께 토이 프로젝트를 시작했습니다. 자바로 코딩을 해보게 되었는데, 적절한 포켓몬을 선정하는 기능을 구현하는 도중, 다른 패키지에 있는 클래스 파일에 싱글톤으로 정의된 배열을 어떻게 불러와야 할지 많이 고민했습니다. 결국에는 getter 메서드를 생성하고, List<포켓몬객체> pokemonList = pr.getPokemonList();와 같은 방식으로 해당 배열을 불러오는 방법을 선택하여 문제를 해결했습니다. 또한, 데이터베이스에 포켓몬 데이터가 올라가지 않는 상황을 다뤄야 할 때도, Pokemon 인터페이스에 Serializable을 구현해야 함을 알았습니다. 이 프로젝트를 통해 내가 무엇을 알고 무엇을 모르는지를 명확히 인지할 수 있는 소중한 경험이었습니다. |
|한소혜|  |

