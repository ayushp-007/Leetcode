# Write your MySQL query statement below
Select id, movie, description, rating 
From Cinema where mod(id, 2) = 1 and description <> 'boring'
Group by rating
Order by rating DESC;