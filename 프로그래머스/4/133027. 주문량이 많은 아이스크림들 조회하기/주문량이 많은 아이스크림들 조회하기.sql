-- 코드를 입력하세요
select f.flavor
from first_half as f
    join july as j
    on f.flavor = j.flavor
group by f.flavor
order by sum(j.total_order) + f.total_order desc
limit 3