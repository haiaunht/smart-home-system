In this multi-part challenge, we're going to build a smart home management system.

## Getting Started

```no-highlight
et get java-smart-home-part-1
cd java-smart-home-part-1
idea .
```

Initialize a Maven project in this directory. You **will** have to use inheritance to enact this functionality. First, read through the entire challenge and consider a possible class hierarchy.

## Core User Stories

### Add a Device

```no-highlight
As a smart home techie
I want to plug something in to a smart plug
So that I can power it on and off
```

Acceptance Criteria:

- I'm presented with a CLI based menu
- One option is to "Add a Device"
- I must specify a name for the device
- The device defaults to being powered off
- The device is added to a global list of devices

### Turn on a Device

```no-highlight
As a home techie
I want to power on a device
So that I can use it
```

Acceptance Criteria:

- I'm presented with an option to "Manage Devices" on the main menu
- When I'm on the "Manage Devices" screen, I'm presented with a list of devices
- I can select a device to work with
- When working with an added device, I can "Toggle Power"
- If the device is turned on and I toggle the power, the system tells me that the device is now powered off
- If the device is turned off and I toggle the power, the system tells me that the device is now powered on

### Add a Switchable SwitchableLight

```no-highlight
As a home techie
I want to add a smart light
So that I can power on or off
```

Acceptance Criteria:

- When I navigate to "Add a Device", I have an option to add a new light
- I must specify a name for the light
- Like any other device, the light defaults to powered off
- Because it is switchable, it also defaults to being switched off

### Turn on a light

```no-highlight
As a home techie
I want to switch on my light
So that I can see at night
```

Acceptance Criteria:

- When I navigate to the "Manage Device" screen specific to my light bulb, I'm presented with an option to switch the bulb on or off
- If the bulb is powered off, I can't switch it on or off
- If the bulb is powered on, I can switch it on or off
- If I turn the power of the bulb off, it is also switched off

### Add a Dimmable SwitchableLight

### Set a Dimmable SwitchableLight's Level

```no-highlight
As a home techie
I want to set the lights dimming level
So that I can set the mood
```

Acceptance Criteria:

- On the "Manage Device" screen specific to my dimmable light, I'm presented with an option to set the dim level
- I must specify a number from 0-100
- If I specify 0, the light is set to be switched off
- If I specify anything greater than 0, the light is set to be switched on
- If I switch on a light on the same screen, it defaults to have a 100% lighting level

### View House Status

```no-highlight
As a home techie
I want to list out all of my devices and their status
So that I can understand the status of my devices
```

Acceptance Criteria:

- When I am on the main menu, I have an option to "View House Status"
- It should output each device's name
- Under the device's name, it should indicate whether the device is powered on or off
- Under a light's name, it should indicate whether the light is switched on or off
- Under a dimmable light, it should indicate what % of power is being sent to the light

### Power Every Device On

```no-highlight
As a home techie
I want to power every device on
So that everything is turned on
```

Acceptance Criteria:

- I have an option on the main menu to power every device on
- When I view the house's status, I can see that all devices are powered on

### Power Every Device Off

```no-highlight
As a home techie
I want to power every device off
So that everything is turned off
```

Acceptance Criteria:

- I have an option on the main menu to power every device off
- When I view the house's status, I can see that all devices are powered off
