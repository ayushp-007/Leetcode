# Write your MySQL query statement below
Select employee_id, salary * (employee_id % 2) * (name not like 'M%') as bonus from employees order by employee_id; 