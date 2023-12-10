package e2e;

import io.github.cdimascio.dotenv.Dotenv;


public abstract class BaseTest {

    //TODO should be declared in .env file
    protected final String ORANGE_SEEDED_ADMIN_EMAIL = "Admin";
    protected final String ORANGE_SEEDED_ADMIN_PASSWORD = "admin123";
}
