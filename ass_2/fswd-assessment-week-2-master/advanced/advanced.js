/**
 * myEvery function
 */
function myEvery (col, fn){
  if (typeof fn !== "function") return undefined;
  if (Array.isArray(col) === true ){
    if (col.length <= 0) return;
    for (let i = 0; i < col.length; i++) {
      if (fn(col[i]) === false) return false
    }
    return true;
  }else if (typeof col === "object"){
    if (Object.keys(col).length <=0) return;
    for (var key in col) {
      if (fn(col[key]) === false) return false
     }
    return true;
  }
   return;
}

/**
 * myEvery function
 */
function mySome (col, fn){
  if (typeof fn !== "function") return undefined;
  if (Array.isArray(col) === true ){
    if (col.length <= 0) return;
    for (let i = 0; i < col.length; i++) {
      if (fn(col[i]) === true) return true;
    }
    return false;
  }else if (typeof col === "object"){
    if (Object.keys(col).length <=0) return;
    for (var key in col) {
      if (fn(col[key]) === true) return true;
    }
    return false;
  }
   return;
}

/**
 * Defaults function
 */
function myDefaults(obj1, obj2){
  if (Object.prototype.toString.call(obj1) !== '[object Object]' || Object.prototype.toString.call(obj2) !== '[object Object]') return;
  for (var key in obj2) {
    if (obj1[key] === undefined) obj1[key] = obj2[key]
  }
  return obj1;
}

module.exports = {myEvery,
                  mySome,
                  myDefaults
                };
