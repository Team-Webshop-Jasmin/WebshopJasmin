import React, { Component } from "react"
import { Link } from "gatsby"

function initNetlifyIdentity() {
  console.log("initNetlifyIdentity called.")
  const script = document.createElement("script");

  script.src = "https://identity.netlify.com/v1/netlify-identity-widget.js"
  script.async = true;

  document.body.appendChild(script);
}

function openNetlifyModal() {
  const netlifyIdentity = window.netlifyIdentity;

  if(netlifyIdentity)
    netlifyIdentity.open();
  else
    console.log('netlifyIdentity not defined')
}

class NetlifyIdentity extends Component {
  componentDidMount() {
    initNetlifyIdentity();
  }

  render() {
    return(<div></div>)
  }
}

const IndexPage = () => {
  initNetlifyIdentity();

  return(
      <Layout>
        <NetlifyIdentity />
        <SEO title="Home" />
        <h1>Hi people</h1>
        <h2 onClick={() => { openNetlifyModal() }}>Login</h2>
        <div style={{ maxWidth: `300px`, marginBottom: `1.45rem` }}>
          <Image />
        </div>
        <Link to="/page-2/">Go to page 2</Link>
      </Layout>
  )
}

export default IndexPage