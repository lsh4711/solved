select category, price, product_name
from (
    select 
    category, 
    price, 
    product_name, 
    row_number() over (partition by CATEGORY order by price desc) as rn
    from FOOD_PRODUCT
) as fp
where rn = 1 and category in ('과자', '국', '김치', '식용유')
order by price desc;