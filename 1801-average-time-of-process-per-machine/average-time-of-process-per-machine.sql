# Write your MySQL query statement below
/*SELECT machine_id, 
       ROUND(AVG(end_time - start_time),3) AS processing_time
FROM (
    SELECT 
        a.machine_id,
        a.process_id,
        MAX(CASE WHEN a.activity_type = 'start' THEN a.timestamp END) AS start_time,
        MAX(CASE WHEN a.activity_type = 'end' THEN a.timestamp END) AS end_time
    FROM activity a
    GROUP BY a.machine_id, a.process_id
) AS process_times
GROUP BY machine_id;*/



 # Write your MySQL query statement below
select m.machine_id,ROUND(AVG(p.timestamp-m.timestamp),3) as processing_time  from activity m,activity p where m.machine_id=p.machine_id and m.process_id=p.process_id and m.activity_type='start' and p.activity_type='end' group by m.machine_id;