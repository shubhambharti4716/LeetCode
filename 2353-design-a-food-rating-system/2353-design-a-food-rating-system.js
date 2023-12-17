var FoodRatings = function (foods, cuisines, ratings) {
  const map_c2fr_pq = new Map()
  const map_f2c = new Map()
  const map_f2r = new Map()
  const n = foods.length
  for (let i = 0; i < n; i++) {
    const [food, cuisine, rating] = [foods[i], cuisines[i], ratings[i]]
    if (!map_f2c.has(food)) {
      map_f2c.set(food, cuisine)
    }
    if (!map_c2fr_pq.has(cuisine)) {
      const fr_pq = new PriorityQueue({
        compare: (a, b) => b[1] - a[1] || a[0].localeCompare(b[0])
      })
      map_c2fr_pq.set(cuisine, fr_pq)
    }
    const fr_pq = map_c2fr_pq.get(cuisine)
    fr_pq.enqueue([food, rating])
    map_f2r.set(food, rating)
  }
  FoodRatings.prototype.changeRating = function (food, newRating) {
    const cuisine = map_f2c.get(food)
    const fr_pq = map_c2fr_pq.get(cuisine)
    const [food_, rating_] = fr_pq.front()
    if (food_ === food) {
      fr_pq.dequeue()
    }
    fr_pq.enqueue([food, newRating])
    map_f2r.set(food, newRating)
  }
  FoodRatings.prototype.highestRated = function (cuisine) {
    const fr_pq = map_c2fr_pq.get(cuisine)
    while (1) {
      const [food, rating] = fr_pq.front()
      const newRating = map_f2r.get(food)
      if (rating === newRating) {
        return food
      } else {
        fr_pq.dequeue()
        fr_pq.enqueue([food, newRating])
      }
    }
  }
}