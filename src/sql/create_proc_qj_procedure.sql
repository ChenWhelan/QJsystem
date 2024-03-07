DELIMITER $$

CREATE PROCEDURE proc_qj()

BEGIN
	SELECT id,name,number FROM student;
END$$

DELIMITER ;
