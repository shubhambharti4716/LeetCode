var eliminateMaximum = function(dist, speed) 
{
    const n = dist.length;
    for (let i = 0; i < dist.length; i++) 
    {
        dist[i] = Math.ceil(dist[i] / speed[i]);
        speed[i] = 0;
    }
    for (const num of dist) 
    {
        if (num >= n) continue;
        speed[num] += 1;
    }
    for (let i = 1; i < speed.length; i++) 
    {
        speed[i] += speed[i-1];
        if (speed[i] > i) 
        {
            return i;
        }
    }
    return n;
};