// Implementing HashMap using Map
class HashMap {
    constructor() {
      this.map = new Map();
    }
  
    put(key, value) {
      this.map.set(key, value);
    }
  
    get(key) {
      return this.map.get(key);
    }
  
    contains(key) {
      return this.map.has(key);
    }
  
    remove(key) {
      this.map.delete(key);
    }
  
    size() {
      return this.map.size;
    }
  
    keys() {
      return [...this.map.keys()];
    }
  
    values() {
      return [...this.map.values()];
    }
  }
  
  const myMap = new HashMap();
  myMap.put("name", "John");
  myMap.put("age", 30);
  console.log(myMap.get("name"));
  console.log(myMap.contains("age"));
  console.log(myMap.size());
  myMap.remove("name");
  console.log(myMap.keys());
  console.log(myMap.values());
  