# Write your MySQL query statement below
SELECT a.id
FROM Weather as a, Weather as b
WHERE DATEDIFF(a.recordDate, b.recordDate) = 1 AND a.temperature > b.temperature;