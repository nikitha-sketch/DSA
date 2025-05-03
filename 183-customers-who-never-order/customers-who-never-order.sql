# Write your MySQL query statement below


SELECT customers.name AS customers
FROM customers
LEFT JOIN orders ON customers.id = orders.customerId
WHERE orders.customerId IS NULL;
