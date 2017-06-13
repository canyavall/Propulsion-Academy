const initialQuestions =
  {
    1: ["Pregunta 1", { 1: ["Respuesta 1 a P1", true],
                        2: ["Respuesta 2 a P1", false],
                        3: ["Respuesta 3 a P1", false],
                        4: ["Respuesta 4 a P1", false]
                      }
      ],
    2: ["Pregunta 2", { 1: ["Respuesta 1 a P2", true],
                        2: ["Respuesta 1 a P2", false],
                        3: ["Respuesta 1 a P2", false],
                        4: ["Respuesta 1 a P2", false]
                      }
      ]
  };

const questions = (state = initialQuestions, action) => {
  switch (action.type) {
    default:
      return state;
  }
}

export default questions;
