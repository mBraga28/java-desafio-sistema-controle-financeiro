CREATE OR REPLACE PROCEDURE calcular_saldo_cliente_periodo (
     p_cliente_id IN NUMBER,
    p_data_inicial IN DATE,
    p_data_final IN DATE,
    p_saldo_final OUT NUMBER
) AS
BEGIN
    SELECT SUM(valor)
    INTO p_saldo_final
    FROM movimentacao m
    JOIN conta c ON m.conta_id = c.id
    WHERE c.cliente_id = p_cliente_id
    AND m.data BETWEEN p_data_inicial AND p_data_final;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Cliente não encontrado ou não possui movimentações no período.');
        WHEN OTHERS THEN
            RAISE;
END;
/