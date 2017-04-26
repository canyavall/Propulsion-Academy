var nums = [1, 2, 3, 4];

var result = nums.reduce(function (acc, num, index, array){
  console.log('acc: ' + acc);
  console.log('num: ' + num);
  console.log('index: ' + index);
  return num;

}, 0);

console.log('result: ' + result);
