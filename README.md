# CloudComputing_hadoop
이 프로그램은 항공지연 시간을 mapreduce하여 연/월 별로 횟수를 취합하는 프로그램입니다.

# 프로그램 사용 절차
### 1. git file을 다운로드하여 하둡파일시스템이 있는 가상 머신으로 옮겨주세요.

### 2. hdfs에 /airline/input 폴더를 만들고 항공자료csv를 넣어주세요.
   
### 3. 아래의 명령어를 차례로 실행하세요. (CLI)
### 하둡 켜기
```
  start-dfs.sh
```
실행 확인 (datanode, secondarynode, namenode가 나오면 하둡 실행중)
```
jps
```

### 파일 실행
아래의 명령어를 사용할 때 /airline/output 폴더가 존재하면 안됩니다.
```
hadoop jar DelayCount.jar com.202044088.DepartureDelayCount.DepartureDelayCount /airline/input /aireline/output
```

### 결과 확인
출발 지연
```
hadoop fs -cat /airline/output/departure-r-00000
```
도착 진연
```
hadoop fs -cat /airline/output/arrival-r-00000
```
