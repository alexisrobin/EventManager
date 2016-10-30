package authentication;

/**
 * Interface which applies an authentication requirement state on an object.
 */
public interface AuthRequirement {

    enum AuthRequirementState {
        IS_REQUIRED,
        IS_NOT_REQUIRED
    }

    AuthRequirementState getAuthRequirementState();

}
