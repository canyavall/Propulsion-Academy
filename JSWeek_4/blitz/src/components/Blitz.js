import React from 'react';
import {Card, CardActions, CardHeader, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';

const style = {
  title: {
    textAlign: 'left',
    height: '50px'
  },
  subtitle: {
    textAlign: 'center',
    fontSize: "25%"
  },
  action: {
    fontSize: "30%",
  },
  div: {
    marginTop: "10px"
  }
}

const Blitz = (props) => {
  const time = Math.floor(((new Date().getTime() - new Date(props.data.created_at))/ (1000*60*60*24))) + " days";

      return <div style={style.div}>
      <Card expanded={false}>
        <CardHeader
          title={ props.data._user.username }
          avatar={ props.data._user.avatar }
          actAsExpander={ false }
          showExpandableButton={ false }
          subtitle={ time }
          style={ style.title }
          subtitleStyle={ style.subtitle }
        />
          <CardText> <hr />{ props.data.content } </CardText>

        </Card>
      </div>
}

// <CardActions>
//   <FlatButton style={ style.action }> Unfollow </FlatButton>
//   <FlatButton style={ style.action }> Like </FlatButton>
// </CardActions>

export default Blitz;
