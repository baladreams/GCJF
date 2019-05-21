var count =0;
/**
 * GCJ 2019 qualification round
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/0000000000088231
 */
exports.fourgone = function (line) {
    count++;
    if (count > 1) {
      var newNum = '';
      var secondNum = '';
      for (var i = 0; i < line.length; i++) {
        if('4'==line.charAt(i)) {
          newNum+='3'; secondNum+='1';
        } else {
          newNum +=line.charAt(i);secondNum+='0';
        }
      }
      console.log("Case #"+(count-1)+":",newNum,secondNum);
    }
}