# tuiles_calculator

## Table of contents

- [Motivations](#motiv)
- [Libraries used](#lib)
- [Files](#files)
- [Visuals](#vis)
- [Credits](#credits)
- [License](#lic)
- [Status](#status)


## Motivations <a name="motiv"> </a>

This repository contains the code created in Java hoping to create an app for builders to count the number of tiles needed to cover a roof if the only thing you know about it are the X&Y coordinates of the corners or the roof and the angles of each part of the roof.

### steps done by the app

1. from all the 2d points and angle, find all the plans that cover the roof
2. calculate all the 3d intersection between the plans
3. calculate all the points that will form all the corners of each part of the roof
4. separate the roof in convexe parts of plans
5. for each part, calculate the number of tiles needed
5. sum for the final results

## Libraries used <a name="lib"></a>

TBC

## Files <a name="files"></a>

```text
TBC
```

## Visuals <a name="vis"></a>

TBC

## Credits <a name="credits"></a>

The idea of this roofing app came from the mind of one of my best friends Julien, carpenter and engineer. The code is solely mine.

## License<a name="lic"></a>

TBac

## Status <a name="status"></a>

This project is currently stopped at step 3. we're currently able to build of the plans, but finding all the interested points is proving difficult, as if we have M starting points we me have up to O(M^2) intersected points and we need to create an algorithm that will select oniy the correct ones, which is proving difficult.