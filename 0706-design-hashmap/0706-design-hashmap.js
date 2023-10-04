class MyHashMap {
    constructor() {
        this.size = 10;
        this.mp = new Array(this.size).fill(null).map(() => []);
    }

    hash(key) {
        return key % this.size;
    }

    put(key, value) {
        const i = this.hash(key);
        const bucket = this.mp[i];

        for (let j = 0; j < bucket.length; j++) {
            if (bucket[j][0] === key) {
                bucket[j][1] = value;
                return;
            }
        }

        bucket.push([key, value]);
    }

    get(key) {
        const i = this.hash(key);
        const bucket = this.mp[i];

        for (let j = 0; j < bucket.length; j++) {
            if (bucket[j][0] === key) {
                return bucket[j][1];
            }
        }

        return -1;
    }

    remove(key) {
        const i = this.hash(key);
        const bucket = this.mp[i];

        for (let j = 0; j < bucket.length; j++) {
            if (bucket[j][0] === key) {
                bucket.splice(j, 1);
                return;
            }
        }
    }
}

// Usage
const hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
console.log(hashMap.get(1)); // Output: 1
console.log(hashMap.get(3)); // Output: -1
hashMap.put(2, 1);
console.log(hashMap.get(2)); // Output: 1
hashMap.remove(2);
console.log(hashMap.get(2)); // Output: -1