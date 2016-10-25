package authentication;

/**
 * Created by Alexis on 25/10/2016.
 */
public interface AuthRequirement {

    enum AuthRequirementState {
        IS_REQUIRED,
        IS_NOT_REQUIRED
    }

    AuthRequirementState getAuthRequirementState();

}
