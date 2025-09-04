DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS wallets CASCADE;

CREATE TABLE wallets (
    id UUID PRIMARY KEY,
    owner VARCHAR(255) NOT NULL,
    balance NUMERIC(38,2) NOT NULL
);

CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    wallet_id UUID NOT NULL,
    type VARCHAR(50) NOT NULL,
    amount NUMERIC(38,2) NOT NULL,
    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_wallet FOREIGN KEY (wallet_id)
        REFERENCES wallets(id)
);