var count =0;

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