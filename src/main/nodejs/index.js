var readline = require('readline');
var rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false
});

var fourgone = require('./foregonesolution.js')
rl.on('line', fourgone.fourgone);