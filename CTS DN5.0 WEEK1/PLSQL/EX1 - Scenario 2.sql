--EXERCISE 1 : SCENARIO 2

ALTER TABLE Customers ADD IsVIP VARCHAR(5);

BEGIN 
    FOR cust IN (
        SELECT CustomerID,
                Name, 
                Balance
        FROM Customers
    )

    LOOP 
        IF cust.Balance > 10000 THEN 

            update Customers SET IsVip = 'TRUE'
            WHERE CustomerID = cust.CustomerID;

        ELSE 
            UPDATE Customers SET IsVIP = 'FALSE'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP; 
    COMMIT;
END;
/
SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;