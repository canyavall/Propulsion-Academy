export const addNewTodo =  (text) => {
    return {
          type: 'ADD_TODO',
          content: text
        };
  }
