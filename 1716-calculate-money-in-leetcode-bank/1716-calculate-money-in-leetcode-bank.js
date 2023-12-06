function totalMoney(n) {
    let totalMoney = 0;
    let dailyDeposit = 1;
    let mondayDeposit = 1;
    
    for (let day = 1; day <= n; day++) {
        totalMoney += dailyDeposit;
        
        if ((day % 7) !== 0) {
            dailyDeposit++;
        } else {
            mondayDeposit++;
            dailyDeposit = mondayDeposit;
        }
    }
    
    return totalMoney;
}