--EXERCISE 1 : SCENARIO 1
BEGIN
    FOR cust IN (
        SELECT CustomerID,
               Name,
               DOB
        FROM Customers
    )
    LOOP
        IF TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12) > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied to ' || cust.Name
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT LoanID,
       CustomerID,
       InterestRate
FROM Loans;
    ADD_MONTHS(SYSDATE,24)
);

COMMIT;