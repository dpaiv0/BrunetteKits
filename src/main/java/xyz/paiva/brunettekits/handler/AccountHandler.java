package xyz.paiva.brunettekits.handler;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import xyz.paiva.brunettekits.prototypes.impl.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountHandler {

    private static AccountHandler instance;

    public static AccountHandler getInstance() {
        if (instance == null) {
            instance = new AccountHandler();
        }
        return instance;
    }

    private final Map<UUID, Account> repository = new HashMap<>();

    public void register(Account account) {
        repository.put(account.getUniqueId(), account);
    }

    @Nullable
    public Account retrieve(@NotNull UUID uniqueId) {
        return repository.get(uniqueId);
    }

    private AccountHandler() {}


}
