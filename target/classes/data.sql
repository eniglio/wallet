INSERT INTO wallets (id, owner, balance) VALUES
    (gen_random_uuid(), 'Eduardo', 100.00),
    (gen_random_uuid(), 'Ana', 50.00),
    (gen_random_uuid(), 'José', 200.00);

-- Exemplo de transações iniciais
INSERT INTO transactions (id, wallet_id, type, amount, created_at)
SELECT gen_random_uuid(), w.id, 'DEPOSIT', 100.00, now()
FROM wallets w WHERE w.owner = 'Eduardo';

INSERT INTO transactions (id, wallet_id, type, amount, created_at)
SELECT gen_random_uuid(), w.id, 'DEPOSIT', 50.00, now()
FROM wallets w WHERE w.owner = 'Ana';

INSERT INTO transactions (id, wallet_id, type, amount, created_at)
SELECT gen_random_uuid(), w.id, 'DEPOSIT', 200.00, now()
FROM wallets w WHERE w.owner = 'José';