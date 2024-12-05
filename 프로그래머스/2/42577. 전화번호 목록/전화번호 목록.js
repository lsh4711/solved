function solution(phone_book) {
    const set = new Set();
    
    phone_book.forEach(phone => {
        let partial = "";
        for (const literal of phone) {
            partial += literal;
            if (partial !== phone) {
                set.add(partial);
            }
        }
    });
    
    for (const phone of phone_book) {
        if (set.has(phone)) {
            return false;
        }
    }
    
    return true;
}