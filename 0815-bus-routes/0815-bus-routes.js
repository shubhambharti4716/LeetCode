/**
 * @param {number[][]} routes
 * @param {number} source
 * @param {number} target
 * @return {number}
 */
var numBusesToDestination = function (routes, src, dest) {
  const stops = {};

  for (let r = 0; r < routes.length; r++) {
    for (const s of routes[r]) {
      if (!stops[s]) {
        stops[s] = [];
      }
      stops[s].push(r);
    }
  }

  const queue = new Queue();
  const visited = new Set();

  queue.enqueue([src, 0]);

  while (!queue.isEmpty()) {
    const [stop, min] = queue.dequeue();

    if (stop === dest) {
      return min;
    }

    for (const route of stops[stop]) {
      if (visited.has(route)) {
        continue;
      }

      for (const s of routes[route]) {
        queue.enqueue([s, min + 1]);
      }

      visited.add(route);
    }
  }

  return -1;
};