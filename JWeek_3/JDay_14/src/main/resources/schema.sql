CREATE TABLE
    "PUBLIC".tweet
    (
        id INTEGER(11) NOT NULL IDENTITY,
        author VARCHAR(50) NOT NULL,
        text VARCHAR(130) NOT NULL,
        PRIMARY KEY (id)
    )