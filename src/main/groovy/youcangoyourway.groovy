/*
GCJ 2019 qualifications 
https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
*/
import java.util.Scanner

br = new BufferedReader(new InputStreamReader(System.in)); 
cases = br.readLine().toInteger()
for(i=1;i<=cases;i++){
    dimension = br.readLine().toInteger()
    String directions = br.readLine()
    println "Case #"+i+": "+directions.replaceAll("S","0").replaceAll("E","1").replaceAll("0","E").replaceAll("1","S")
}