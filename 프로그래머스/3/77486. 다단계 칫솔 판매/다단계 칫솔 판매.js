function solution(enroll, referral, seller, amount) {
    const map = new Map();
    
    enroll.forEach(name => {
        map.set(name, {
            name,
            money: 0,
            profits: [],
            parent: null,
            children: []
        });
    });
    
    referral.forEach((parentName, idx) => {
        if (parentName === "-") {
            return;
        }
        const childName = enroll[idx];
        const child = map.get(childName);
        const parent = map.get(parentName);
        parent.children.push(child);
        child.parent = parent;
    });
    
    seller.forEach((seller, idx) => {
        const profit = amount[idx] * 100;
        map.get(seller).profits.push(profit);
    });
    

    for (let idx = enroll.length - 1; idx >= 0; idx--) {
        const personName = enroll[idx];
        const person = map.get(personName);
        person.profits.forEach((profit, idx) => {
            if (!profit) {
                return;
            }
            const parentProfit = getParentProfit(profit);
            person.money += profit - parentProfit;
            person.parent?.profits.push(parentProfit);
        });
    }
    
    return enroll.map(name => map.get(name).money);
}

const getParentProfit = (profit) => {
    return parseInt(profit / 10);
}