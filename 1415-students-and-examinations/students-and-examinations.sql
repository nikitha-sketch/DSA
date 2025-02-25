# Write your MySQL query statement below
select 
    S.student_id,
    S.student_name,
    SU.subject_name,count(E.student_id)attended_exams


from Students S 
cross join Subjects SU 
left join Examinations E
    on E.student_id=S.student_id
    and E.subject_name=SU.subject_name
group by S.student_id,S.student_name,SU.subject_name
order by S.student_id,S.student_name,SU.subject_name;