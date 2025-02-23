SELECT patient_id, patient_name, conditions 
FROM Patients 
WHERE conditions REGEXP '(^|[[:space:]])DIAB1[0-9][0-9]($|[[:space:]])';
