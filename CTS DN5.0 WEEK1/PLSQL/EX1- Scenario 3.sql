BEGIN
    FOR loan IN (
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || loan.Name ||
            ', your Loan ID ' || loan.LoanID ||
            ' is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/