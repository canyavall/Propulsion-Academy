import React from 'react';
import { Card, CardHeader, CardText } from 'material-ui/Card';
import { Link } from 'react-router-dom';

const style = {
  title: {
    textAlign: 'left',
    height: '50px',
    fontWeight: 'bold'
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
  },
  cardText: {
    fontSize: '40%'
  }
}
/**
 * Shows a blitz
 * props:
 * *Data: User data
 * *ShowHeader: Toggle to show the cardheader
 */
const Blitz = (props) => {
  console.log(props);
  const titleToLink =  "users/" + props.data._user._id;
  const title = <Link to={ titleToLink }>{ props.data._user.username }</Link>
  const time = Math.floor(((new Date().getTime() - new Date(props.data.created_at))/ (1000*60*60*24))) + " days ago";
  const cardHeader = (<CardHeader
            title={ title }
            avatar={ props.data._user.avatar }
            actAsExpander={ false }
            showExpandableButton={ false }
            subtitle={ time }
            style={ style.title }
            subtitleStyle={ style.subtitle }
          />)

  const header = (props.showHeader) ? cardHeader : "";
  return <div style={style.div}>
  <Card expanded={false}>
    { header }
      <CardText style={style.cardText}> { props.data.content } </CardText>

    </Card>
  </div>
}


export default Blitz;
