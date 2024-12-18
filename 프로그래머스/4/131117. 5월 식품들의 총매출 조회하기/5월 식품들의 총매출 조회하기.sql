select fp.product_id, fp.product_name, fp.price * fo.total_amount as total_sales
from food_product as fp
join (
    select product_id, sum(amount) as total_amount, produce_date
    from food_order
    where '2022-05-01' <= produce_date and produce_date < '2022-06-01'
    group by product_id
) as fo
on fp.product_id = fo.product_id
order by total_sales desc, product_id;
