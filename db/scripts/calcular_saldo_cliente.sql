CREATE OR REPLACE PROCEDURE calcular_saldo_cliente (
    p_cliente_id IN NUMBER,
    p_data_final IN DATE DEFAULT SYSDATE,
    p_saldo_final OUT NUMBER
) AS
BEGIN
    SELECT SUM(valor)
    INTO p_saldo_final
    FROM movimentacao m
    JOIN conta c ON m.conta_id = c.id
    WHERE c.cliente_id = p_cliente_id
    AND m.data <= p_data_final;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Cliente não encontrado ou não possui movimentações.');
        WHEN OTHERS THEN
            RAISE;
END;
/