const initialUser =
  {
    totalQuestions: 0,
    rightQuestions: 0
  };

const users = (state = initialUser, action) => {
  const newState = { ...state };
  switch (action.type) {
    case "INC_QUESTION":
      newState.totalQuestions++;
      return newState;

    case "INC_RIGHT":
      newState.rightQuestions++;
      return newState;
      
    default:
      return state;
  }
}

export default users;
